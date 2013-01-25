Original page is located at: http://mochadoom.sourceforge.net

Hello, and welcome to the Mocha Doom's official project page!
I will introduce the project to you via a series of Questions and Answers, which I felt would better anticipate the many questions that arise as concepts and facts are introduced. Have fun ;-)

What is Mocha Doom?

Mocha Doom is an ambitious project which aims at creating the first complete, functional pure Java source port of the famous game Doom by id software.

Hasn't this already been done before?

Sadly, no. Emphasis on "complete", "functional" and "pure Java" goes here.
There are several reasons for that, and if you're a programmer or just curious to learn more, you can learn about the goriest details here.

You're wrong, I've seen "Doom like" games written in Java before.

Yeah, but they are not Doom and have nothing to do with the Doom source code as a whole. Nothing prevents you from writing a 3D engine in Java (there are several) and using it from making a First Person Shooter game that looks kinda like Doom (there's a reason why they are called "Doom Clones") but try as you might, you won't find one that is an actual source port of Doom in PURE Java.

You're wrong, I've seen this "Doom" for Java game. It says it's "Doom" so it's the real deal, right?

OK, try running PWADs on it then :-D
That pityful joke ain't a Doom source port, it's a generic maze3D-like engine with the logo "Doom" slapped on it, as are many other similar so-called "source ports". It does NOT play or feel like Doom, and does not use Doom's original data resources like a true source port would (ripped graphics and sounds don't count!).
That's EXACTLY the kind of gap this project aims at filling.

OK, but I've seen c2Doom, and that IS for mobile devices which use Java!

No, c2Doom is actually a native Symbian binary application that only works on certain Nokia phones and versions of Symbian, and it's written in straight C.
No Java to be found there.

But there's Doom for android, and Android uses Java for development!!! There you have it.

Actually, no. That's a hybrid Java/C application where only the user interface and launcher are written in Java, as explained here (PDF link).
The rest are JNI wrappers around a native code library written in pure C, libdoom.so, which implements the actual game logic, rendering etc. and which is called in turn by Java.
So the underlying engine is still written in C and Java just sits "on top" as an intermediary. 
From a "Java Doom" perspective, and perhaps due to the Android platform's Java limitations, that's an interesting workaround, and surely allowed the author to release a working blob quicker, but that's not quite the goal of this project.
But there was DoomCott!!!

Come on, you really think I missed that one? ;-)
It was equally ambitious, but never went past displaying a screen wipe (only claimed to do so, I've never actually seen it working as it crashes most JVMs, and in an (unreleased) version, (allegedly) the ability to display the menus and automap (I think).
In any case, it's long gone and abandoned, and all that's left is a broken applet and a few teaser screenshots. I even tried to contact the author, hoping that I could get some insight or continue his work, but no such luck.

But there's Ruin and the Stark engine!!! They are in pure Java, and they ARE Doom related!

Close, but no cigar. Stark was actually a "Doom-like" rendering engine written from scratch which was able to load PWAD data, however it lacked any Doom-like game logic (from what I can remember) and never went past that stage.
Also long gone and adandoned. RUIN is the only project that actually uses it. Unfortunately, even is the Stark source code was released, it's long gone from the Internet. Not even Google Cache and Archive.org seem to be able to bring it back.
However, unlike the previous attempts, this was actually a step in the right direction.

But uhm...there's this PC emulator written in Java which runs Doom.exe...

Die.

But there are some functional FPS in Java which use Doom textures and monsters. Aren't those Doom? Couldn't you just throw some Doom textures and monsters here and there and call it Doom? Or try recreating Doom as close as possibly within another engine?

No. In such "Doom recreations" as I call them, you can't load PWADs or DEHACKED lumps, which are also part of what Doom is all about: the inner working are just too different, so different that you'll end up with a total hack.

Come on, there are ports of Doom for the Amiga, ZX Spectrum, C64, Flash, Sun, PHP, FORTRAN, iPhone, JavaScript etc. how can it be so hard to make a Java one?!

As optimistic as this statement sounds, it's actually pretty generalistic and misleading.
There aren't any "PHP and JavaScript" Doom source ports around, unless they're like that "Doom for your mobile" hoax ;-)
The "flash" port that hit the internets a couple of years ago is actually an Adobe Flex wrapper around a...you guessed it, Doom library written in C.
While, as a programmer, I fully respect the author's work and time he put into it, that's what I define the "quick and dirty way" to port Doom. The same author tried making a pure ActionScript port of Doom before that, but gave up on it as soon as Adobe Flex became available.
The iPhone port itself also uses a C core library wrapped around by the the necessary iPhone APIs in Objective C.
The "source ports" on the ZX Spectrum/C64 are actually "recreations", of the "Doom logo slapped on generic maze 3D engine" variety.
For one, they were made before id even released the Doom source code in the public domain!
As impressive as it is for those platforms, that ain't Doom, and it totally unrelated to Java's specifics anyway.
The Amiga, SunOS etc. source ports are proper source ports based on the original id source code, but there's nothing too hard about porting Doom to a platform that has a compatible C compiler, platform quirks notwithstanding.
And no FORTRAN and COBOL ports around either...
OK, so what gives?

I had a quite lengthy reply here, but I felt that it fits better into the tech page.