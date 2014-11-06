General Frequently Asked Questions

What aspects of the original Doom are supported in Mocha Doom?

All those I managed to implement ;-) Nominally, loading PWADs and single lumps, the lighting/colormap system, palette effects, BSP-based map system, automap, scalable window sizes, screen wipes etc.
Unlike a recreation, this is actually a functional port of the source code, with the ultimate goal being at least as functional as the original Doom, if not more (e.g. by including limit removing features, some of which are already implemented).

What's the state of art in Mocha Doom's development NOW?! Can I play it?

As of now (8/1/2011), it's in a "Tech Demo" stage, which means that the engine is functional enough to demonstrate its potential (it can load and display E1M1, the player can be moved around, it can load PWADs etc. ) but is not really a complete, playable game, as many things don't work yet. Still, even in that state, it's MUCH more advanced than almost any non-C source port of Doom ever made, and surely the most complete Java one. And it's just gonna get better.

Is Mocha Doom compatible with the original IWADs and user-made PWADs?

Yes! That's the whole point of the project. Not just "recreate" Doom in Java, as in making a look-alike, but provide a fully functional source port that works with the original data as much as possible, and of course the ability to load user-generated content (which is the very SOUL of Doom) couldn't be overlooked.

What operating systems does Mocha Doom support? Is recompilation required?

In the current state of the art, Mocha Doom has been tested to run correctly and reliably under Windows XP, Vista, Seven, Ubuntu and Debian Linux, and OS X 10.6 (Tech Demo v1.3 and onwards). No recompilation needed, even for 64-bit systems ;-)
All that is required, is the presence of an -at least- Java 6 compliant JVM.

What Java virtual machines are supported? What's the "recommended" one?

Testing hasn't been exhaustive, however the reference codebase is compiled using Sun/Oracle's JDK, and runtime debugging is performed using the same. It's recommended to use the latest, and if possible, more recent than 6u16 for performance reasons.
It's advised to use only the client JVM, as the server one was found to actually slow things down and cause uneven performance: the code is already very tight and hand optimized as it is, so the server JVM's aggressive behavior does more harm than good. OpenJDK 1.6 will also work, while Java 5 JDKs and compilers will give errors and additional warnings in most cases (but perhaps it's possible to convert the codebase without too much hassle). Finally, it's impossible to compile and run with older versions of Java, because the lack much of the new functionality that Mocha Doom uses. It's unknown how e.g. IBM's or Jrockit's JVMs would cope, or if GCJ could handle it.

Can Mocha Doom be compiled to an .exe? Can I use J#/C#/.NET with it?

As I said, I haven't tested if GCJ will compile any parts of it, but chances are that it will crap out on the AWT/java.image2D stuff. J# will surely get stuck somewhere, while porting/forking to C# might be just possible (it's a future possibility).

Does Mocha Doom use hardware acceleration/OpenGL/a third party rendering engine?

No, Mocha Doom uses a direct port of Doom's rendering engine, optimized and tailored to Java's needs with the aim of being as compatible and faithful to the Doom experience as possible. Internally, the engine has a few innovations in that it's the first Doom engine to feature multithreaded (parallel) rendering of wall patches and floors, which has proven to give actual benefits on multi-core processors.

How do you manage to get so fast screen rendering in pure Java?

The rendering subsystem uses Java's BufferedImages mapped to video memory by the native OS. This is a transparent process from the development point of view, but a compliant OS and video drivers are required. This allows Mocha Doom to use the same rendering functions -obviously converted to Java- as the other source ports, rather than Java's geometric drawing primitives, which would be inadequate for this sort of task.

Does Mocha Doom use native code/JNI/C libraries for speed?

No, Mocha Doom is 100% pure Java. Actually, NOT to use any of that is a stated goal of this project, both to make a fully managed version of Doom that is more developer friendly, can be ported easily to other non-C languages, to work around C/C++'s portability issues and to create a truly cross-platform port.

Will Mocha Doom run in a browser?

Mocha Doom is intended a standalone, desktop Java application. It relies on the full feature set of the Java 1.6 SDK, and also relies on the ability to perform disk-based random file I/O and advanced video rendering functions, some of which are unavailable or restricted when running inside an applet. I had tried to release a much more limited applet demo in the past, but the result crashed most plugin containers or ran with unexpected side effects, and was practically impossible to debug. Therefore, making an applet-friendly version is not a priority, as of now. However, there might be a Java Web Start version in the future, similarly to Jake2, which has far less limitations compared to Applets.

Is there any connection with the Jake2 project?

Other than being both pure Java ports of two popular iD software's video games, no. There are a lot of differences e.g. Mocha Doom won't be using OpenGL for enhanced cross-OS compatibility, but several concepts have been "borrowed" from Jake 2, especially regarding the methods used to port complex game C code to Java, how to map structs to classes, how to implement binary loaders etc. so, in a sense, there is a distant relationship between the two. Other than that, I never was a programmer for the Jake2 team, nor did any Jake2 programmer work on Mocha Doom (yet)..

Will Mocha Doom ever have sound?

Eventually yes, when the rest of the code is functional enough. When that moment comes, priority will be given to using a cross-OS solution with no native wrappers, just like the rest of the code.

Will Mocha Doom ever have network play?

Typically, some networking functions must be implemented for even single player games to work -they are a bit crude now-. In due time proper netcode with the ability to start netgames will be added, hopefully maintaining network-level compatibility with other source ports.

Does Mocha Doom have any Boom/limit removing features?

As of now, Mocha Doom is mainly a "vanilla compatible" source port, however it does have some limit removing features borrowed from Lee Killough's Boom source port, e.g. Hashtable-based resource management, dynamic allocation of sprites and visplanes etc., while later on support for sprites and flats in PWADs will be added. For the rest, Mocha Doom only supports vanilla Doom linedefs, sector tags, etc. so Boom maps may load but will crash in most cases.

Does Mocha Doom support Heretic/Hexen/Slopes/ZDoom features?

Not for now. Once the basic Doom support is stable I might consider expanding it with some of these features, although Boom compatibility is a more probable next step.

What development tools are you using for Mocha Doom?

Mainly Eclipse, a free Java IDE written in Java, Dev-Cpp for cross-checking and navigating the original C source as well as writing test cases, DoomBuilder (a free Doom level editor), XWE (a free, but no longer updated) Doom lump editor, and Hexplorer for direct inspection of lumps.

Why don't you use SVN for a repository?

I got this question A LOT of times, but see above: my Java IDE of choice has built-in CVS integration which works like a charm and, at least for this phase of the project's lifetime, CVS is suitable (I just need a way to upload and backup my work for convenience, since I develop on several different machines).