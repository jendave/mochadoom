Some of Doom's source code features and quirks and how they are addressed in Java/MochaDoom

If you read the introduction at the main page, you'll have read me mentioning the infamous "original C Doom source code" a LOT of times, and how it's hard to map it to other languages that are not C/C++/assembler etc.

Well, here you can read some more in-depth details of what is going on in the world of Doom source ports, and how Mocha Doom has tackled some of the issues that likely prevented most attempts at a pure Java Doom to gain momentum.

By all means, it was NOT an easy task, and I'm not even sure it would be possible at all with earlier Java versions (earlier than 1.4.2, at least).

OK, so what's the deal with Doom's code and (most) existing source ports?

As you might have guessed, there's actually a deeper issue at hand here: if you poke deep enough, you'll soon discover that almost all Doom source ports in existence are written in C or, at most C++ and there's also an odd one in Delphi (which however is a functional copy of the C code). There's nothing strange about that, those platforms are perfectly capable of compiling and running it, after all it's written in C!
Without intending to demean the time and effort that the authors of those projects put into them, making a source port in C or by wrapping around C code is relatively trivial: you don't have to change and understand how ANY of the data structs or methods work, except those that are specifically needed to interface with your platform (e.g. I/O, sound, video, etc.).

To put it simply and bluntly: DEVELOPING A DOOM SOURCE PORT IN C, C++ OR EVEN DELPHI, IS A RELATIVELY STRAIGHTFORWARD TASK, evidenced by the ease at which straight ports of the original LinuxDoom code -or of more develpment-friendly ports such as prboom and Chocolate Doom have been released for home consoles, portable devices etc.

To make a simplification, the Doom codebase may be Hell on Earth (pun intended), but a programmer doesn't actually need to go through every line of it or worry about how e.g. patches and columns are read from disk and drawn to the framebuffer, or whether the type fixed_t is just a typedef for 32-bit signed integers, or if some parts of the code use function pointers. With -at most- a few adaptations for a specific compiler and platform, a few compile commands will do the trick

The above was probably an extreme oversimplification, but not far from reality if someone wants just to port an already functional C or C++ port without changing the language or at least when using a language that can map 1:1 to the original C, functionality wise -DelphiDoom is a notable example, and the only source port, besides Mochadoom, written in a non-C language.

That's one of the reasons that the impression that Doom is easy to port on every platform was formed: Doom is only "easy" to port on platforms that can use compiled C code, and this obviously doesn't include pure Java. Or pure C#.
Or pure Javascript.
Emphasis on pure).
Now, consider trying to port the Doom source code in a language that IS NOT C, and furthermore has no explicit pointers to primitive data types, no function pointers, no lightweight structs/objects with value semantics, no unions, hell, not even unsigned types, which are all essential features of Doom's codebase. Imagine trying to port it to a language where you can't abuse #defines, you can't typedef or cast your way around things liberally, you can't poke and prod at any location in memory at your whim....yup, it's not pretty when the whole codebase relies on it.

Now even though the Doom source code is full of those "features", the average source port developer does not need to worry about them, as long as he/she keeps to C/C++, in fact it's how things are done. But when porting it to a language lacking some or all of these features, things can get tricky. It's not just a matter of "translating" the source code to another language: you have to actually understand how stuff works and reinvent everything, if you wish to use as much of the original codebase "as is" within translation limits, and even if you want to make a functional equivalent.

That's one of the main reasons none has tried -or succeeded- in making a Doom source port in pure Java. The "easy" way would be to wrap a C library, leave the nasty pointers, unions etc. in there, and have Java call everything through JNI, nice and (relatively) clean. Et voila', "Java Doom" would be born (FUN FACT: the Android port of Doom uses this exact approach, wrapping around a native library based on prboom).

However, that's not what we're doing around here. The "hard" way, which is what we're doing, is building a proper Object Oriented API around the Doom game engine, which will separate functions, code pointers, modules and structs into clear-cut Objects as much as possible, and will preserve as much of the original algorithms in order to achieve a functional simulation of the original C source code. Furthermore, tradeoffs between performance and strict encapsulation will be performed, preferring e.g. direct field access rather than using getters/setters when this is performance critical, to avoid the "Enterprise pitfall".

Fixed point arithmetic:

The original Doom source code was meant to run on CPUs without a FPU (including 386 and 486 SX) so a compromise was chosen: floating point types were ditched in favour of an internal 16.16 fixed point arithmetic model (16 bit for the integer part, 16 bits for the fractional part). In the original C code, and in most source ports, this feature is preserved exactly as is, and is a prime example of something most source port authors might not even be aware of unless they try and modify something that uses them. Their continued use is also dictated by the way the original data is stored in existing WAD files (official and user-made levels) and the desire to keep compatibility with it, which is also one of the set objectives of MochaDoom. In practice, getting rid of them would be too hard, as they are all over the code, and they are often handled interchangeably with normal signed integers, so it's not even always possible to tell when an "int" is used as an integer or as a fixed point number, without painstakingly tracing all the code.

The Doom way:

Fixed point numbers are actually a simple typedef of signed integers (found in fixed_t.c and fixed_t.h).
This approach has the advantage that addition/subtraction, comparison and bitwise operations can be performed with standard C operators with no speed penalty, without operator overloading or use of auxiliary methods. Only multiplication and division are performed by specialized methods. Also, the type is perfectly interchangeable with normal integers (and often it is handled as such).

Mocha Doom's way:

At first, I had opted to map the fixed_t type into an fully encapsulated object, but soon realized that the most common operations were additions/subtractions/logical/comparisons, for which I needed to write specialized auxiliary methods and clutter up the code, while fixed multiplication/division operations were relatively rare. Also, the type appeared too often and needed per-instance initialization, with the most extreme cases being HAVING A WHOLE PRECOMPUTED SINE TABLE TREATED AS FIXED_T. That was obviously too much overhead to ignore (having 10000 frequently used fixed_t objects? No thanks!). Therefore, I decided to simply have normal Java ints in lieu of "fixed_t" in the code, and clearly mark them as such with javadoc comments or prefixes. This also allowed me to keep most methods unchanged or with minimal adapatations, and is part of what gives Mochadoom its speed and compatibility.

Image format:

Doom stores its images (called "patches") in a packed, row-sparse column-major format. The actual struct, called patch_t, stores an implicit array of smaller structs called column_t, which in turns stores an implicit list of ANOTHER struct, called post_t, which is actually the same as column_t. By "implicit" I mean that there are no placeholder arrays for columns or posts anywhere: their presence can only be understoof indirectly by seeing how actual rendering code reads PAST the "end" of the patch_t struct (!) and into the columns, up to their implicit end, marked by a "sentinel" value.

Here's the actual definition from the Doom code:


typedef struct 
{ 
    short		width;		// bounding box size 
    short		height; 
    short		leftoffset;	// pixels to the left of origin 
    short		topoffset;	// pixels below the origin 
    int			columnofs[8];	// only [width] used
    // the [0] is &columnofs[width] 
} patch_t;

// posts are runs of non masked source pixels
typedef struct
{
  byte topdelta; // -1 is the last post in a column
  byte length;   // length data bytes follows
} post_t;

// column_t is a list of 0 or more post_t, (byte)-1 terminated
typedef post_t column_t;

The "list of 0 or more post_t" actually begins AFTER the patch_t struct, and can only be accessed with pointer arithmetic. I had to split hairs at the rendering function to see how they did it. Also, reading them from disk is a no brainer in C/C++: the loader only needs to know how long the entire patch_t is, loads it ALL in memory et voila', the pointer arithmetic in the renderer will take care of the rest. No need to know exactly how many posts are in a column until you actually render them.

Mocha Doom's way:

Of course, in Java we need the data to be perfectly addressable in a byte[] array. We can't use "indirect" addressing or pointer arithmetic (well, there's Java Unsafe...but I'm not using that). An "easy" way would be to just treat patches as raw byte[] lumps but then we'd lose access to fields etc. which would have to be emulated with setters/getters (it's possible, however, and I'm considering it as an alternative implementation). However, often the renderer code needs access to individual columns, and there's no way in Java to provide an "alias", aka pointer in the middle of an array without using an array + index, only to the beginning of whole arrays.

Therefore, I added an array of column_t's in the patch_t class, and modified the loader in order so that each column makes an "introspection" of itself during loading and reports back with the ACTUAL number of post_t's contained, their delta and data offsets and lengths. The actual raw column data is read whole into a byte[] array, which can then be copied efficiently around memory (e.g. when compositing textures).

This has the benefit that columns and their posts are now individually addressable without "seeking" inside them, thanks to the extra info gathered during loadtime. This actually makes certain rendering functions more compact, readable, and even more efficient, as now a column can be clipped by skipping directly to the visible posts.

Unsigned types

Simply put, C allows for the use of unsigned types, Java does not. And of course Doom uses them. A lot. Ouch.

The Doom way:

First and foremost, Doom renders the screen in big arrays of "unsigned chars" which are typedeffed into "byte". That's a nuisance, as the name clashes with Java's "byte" which are actually "signed chars" in C (a name which in turn clashes with Java's char). Some types such as array indexes are specified simply as "unsigned", plus there is the use of unsigned shorts etc.

Mocha Doom's way:

In some areas where performance is critical, like screen buffers, those are simply defined as signed bytes. This has the benefit of keeping bulk copy and blitting operations intact, and even most arithmetic and logic operations, at the bit level (there's no difference between signed and unsigned as far as most bit operations are concerned (excect arithmetic right shifting), only in the result interpretations). Of course, in the few cases where the full 0-255 range is desired, a cast to the next bigger type can be made. This has been shown by benchmarking to have no measurable performance penalty whatsoever (either it's very efficiently compiled, or byte operations are blown to full integer operations anyway).

So in general, I DON'T widen operands unless it's absolutely necessary. Most "unsigned" indexes are left as-is, because Java can't use indexes greather than Integer.MAX_VALUE in arrays anyway, so there's no point in using longs (they would only result in a compilation error and the need to add a cast).

VLB (Video Linear Buffers) defined as linear byte buffers can also be directly mapped to BufferedImages, and have the most direct blitting possible, resulting in ultra-fast (for Java, anyway) software rendering, as well as some neat tricks with the palette effect.

The only unsigned type that has an equivalent in Java is the unsigned short, which maps perfectly to char and works like a charm, with a full 0-65535 range when required.

BAM Angles:

The Doom way:

Similarly to fixed arithmetic types, Doom uses a typedef to unsigned integers called "angle_t". This turns out to be a 32-bit mapping to the range of angles [0,2*PI) (a full circle), where values are set as follows: 

ANG90=0x40000000
ANG180=0x80000000
ANG270=0xC0000000

with intermediate angles being obvious. For computations such as additions and multiplications, they are just multiplied and added directly and arithmetic overflows/underflows are ignored, thus simulating angle modulation cleanly. E.g. ANG270+ANG180=ANG90. To actually use them in sine and finesine computations and the such, they are shifted right by 19 positions (through the use of the constant ANGLETOFINESHIFT = 19) and thus only the highest 13 bits are used to look inside sine and cosine lookup tables (which only have 8192 addressable entries each).

Mocha Doom's way:

The biggest problem is of course that we can't use unsigned int types, so we must adopt one of the following approaches:

Use standard signed 32-bit ints. This is efficient as far as addition/subtraction and memory/register usage is concerned, but creates problems with comparisons, e.g. ANG270 would compare as SMALLER than ANG90, which is wrong. This can be solved by the use of a specialized comparator, which however would add extra overhead. Also, when right-shifting, the >>> operator rather than >> must be used, or else the "sign bit" (which is not a sign at all, in this case) will trail and cause undesired underflows.
Use long (64-bit signed) integers. This solves the comparison problems, of course, but overflows/underflows etc. after cumulative arithmetic operations must be taken into account. This is the actually used approach in most situations, and overflow/angle modulation is assured by ANDing the results after every series of operations with a 0xFFFFFFFFL constant.
Mix the two. It's more risky, but if done correctly should give the best compromise between performance, ease of coding and memory bandwidth.
Strings and characters

Simply put, C has no strings :-p They're pointers to null terminated char arrays. This forces you to be a bit anal when manipulating them, and in most cases their length is not known a-priori. On the other hand this approach gives an advantage when working with length-limited strings, as happens a lot in Doom.

The Doom way:

Every "string" is either a char* or a const char*, and usual C string manipulation techniques (and problems) apply. nothing too special here.

Mocha Doom's way:

whenever immutable names read from lumps, canned messages etc. need to be read/assembled and passed along, String and StringBuffer objects are used. This keeps the codebase clean, and even gives some advantages when manipulating. In some instances where per-character manipulation is desired, toCharArray() can be used in conjuction with StringBuffer.
When character buffers are really what is desired (e.g. to enter text), they are used in Java too or replaced with StringBuffers, otherwise String immutables do the job just fine, and with less room for screwups.

Lump caching and zone memory management

Doom used a relatively simple yet clever resource management and caching system: almost every resource needed by the game was stored in one or more external files called WAD files, which contained the levels, sounds, graphics etc. as well as some special data such as palettes, texts, etc. used by the game. Lumps could be sought for by name (8 characters, case insensitive), or by number (for sequential reads or several related lumps), and it was possible to obtain either a lump's name given its number, or viceversa, it's number given its name. Furthermore, whenever a lump was read, it was usually cached in memory so that further queries for that particular lump, returned the cached memory location immediately. This resource management system is what allowed Doom its extensibility by third party add-ons, so no source port can be called such without full support for it. Doom also features a dynamic memory manager which simplifies caching/uncaching resources and allocating memory for the game's purposes.

The Doom way:

Searching for a lump will be broken down to looking for a specific index inside the loaded WAD files. When found, if not already loaded, a lump will be loaded "raw" in memory and the caller will be returned a void* pointer to the raw data, which will then be interpreted as the proper type of C struct ("type punning"). A complex memory manager also determines when cached stuff can be unloaded in order to fit into limited memory.

Mocha Doom's way:

While it's possible to implement everything down to reading a lump from disk, there's a problem: we can't pass raw void* pointers around like in C, and the calling function expects an object of the proper type to be returned (e.g. a patch_t).

Since in Java we can't perform arbitrary casts or rely on implicit struct memory order, the solution was to turn every struct that could be read from disk into an object type implementing a special interface, called CacheableDoomObject.

Raw lumps are read into ByteBuffers, which are then passed to the CacheableDoomObjects' unpack() method, which parses the raw bytes appropriately. Finally, the unmarshalled object is "cached" by creating a reference from it in the lump cache, and so subsequent searches for it will return the already unmarshalled object itself, which is, effectively, caching.

Due credit goes to the Jake2 project which used a very similar approach, which was adapted for Mocha Doom's purposes.

This approach has the advantage of strict type safety, allows the "mass unmarshalling" of arrays of similar objects, allows writing complex per-field unmarshalling code only once, and at the source code level, works almost transparently for the programmer when a lump needs to be loaded from the WAD resource manager.

Also, Java needs no explicit memory management, although it's possible to unload a cached object that is not used (rather, having it garbage-collected by nullifying all references to it).