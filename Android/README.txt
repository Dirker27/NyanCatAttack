Android Group Project: "NYAN CAT ATTACK!"			||   --        --
													||  |..\      /..| 
Authors: 	Dirk Hortensius 	[dirker27]			||  |...\    /...|
			Erich Alderfer		[er1chald]			||  |....\--/....| 				   
			Jonathan Lester		[jonal90]			||  |.............|
													|| |..............|
Course: 	CS 2114 [Soft.Design/Data Dtructures]	|| |...0X.....0X..|
													|| |...XX...X.XX..|
Instructor: Eli Tilevich							|| |.00.........00|
													|| |.00.X..X..X.00|
Date:		April 29, 2012							||  |...XXXXXXX..|
													||   |..........|
====================================================++    ----------

Project Overview:
	Nyan Cat Attack! (Simply titled "Nyan" in the current Submission)
	is a sidescrolling platformer game, in which the user tries to keep
	"NyanCat" alive, by using Jump and Dash commands to navigate the
	series of constantly moving platforms present on the map. If NyanCat
	falls through to bottom of the screen, NyanCat dies, and the game is
	Over.
	
Start Up:
	On execution, the Application calls a "Launcher" Activity. This activity
	will launch a second "NyanCatAttack" activity at the press of the primary
	"Launch" button. The game itself is played on the "NyanCatAttack" activity.
	When the game ends (either through NyanDeath or pressing "Back"), the 
	application returns to the "Launcher" Activity, and a new game may be
	started through pressing the "Launch" button again.
	
Controls:
	The game implements 2 touch-based inputs to navigate NyanCat
	
	Jump:
		Tapping the LEFT side of the screen will cause NyanCat to Jump.
		Continued contact with the screen FROM ANY POINT will continue
		the duration of the "jump", during which time gravity is dampened to
		allow longer jumps and a higher Max Jump Height.
	
	Dash:
		Tapping the RIGHT side of the screen will execute a NyanCat Dash,
		where Nyan Cat will charge forward for the duration of the hold.
		After the dash is completed, NyanCat will move more slowly until 
		it returns to its originial position on the screen.
		
	Jump and hold MAY NOT be executed Simutaneously. Likewise, it is 
	REQUIRED that all contact with the screen at all points must be ceased,
	or the next input command will not be executed.
	
Design/Implementation:
	This program implements various topics covered in class
		
		Inheritence: 
			All objects displayed on screen are sub-classes of
			Abstract class GameObject, which is itself uncallable (due to
			being abstract), and implement a static/dynamic type call in
			method NyanCatView.drawObj, where the token GameObject g
			can call the .name() method of the subclasses in a Debug Output.
			
		Data Structure Iteration:
			All GameObjects being processed in the game are stored in a 
			basic LINKEDLIST - style data structure, implemented through 
			abstract class Linked, and its two inheritors Stack and Queue.
			These classes are an extension of Iterable, as taken advantage
			of in the many for:each loops used to process the objects.
			
			The use of these linked lists allowed us to better control 
			order of output in the onDraw method, and to "scroll" through
			the massive list of GameObjects, without actually having to 
			draw objects not on screen, saving cycles.
			
		MVC Design:
			This production uses MVC design to isolate and encapsulate
			all of the separate game functions. No class is able to access
			any data that is irrelevant to its execution, and the model
			of the game remains isolated from the IO interface implemented
			in the Activity/View of the program.
	
	This program also features several programing aspects learned outside
		of the course parameters
		
		Threading:
			In order to constantly update the positions of GameObjects
			without requiring constant user input, a thread is set in
			NyanCatActivity.background to constantly "kick" the model 
			every set amount of milliseconds, enabling the model to update
			and the view to invalidate without the need for user input.
		
		Android Resource Management (AssetManager):
			To display custom images, we accessed the Android AssetManager
			class to allow us to access images (made in GIMP), and decode
			them into Bitmap objects to use for output.

Notable Issues:
	
	Due to Web-Cat submission limitations, we were unable to send our image
		folder (assets/img) through with its contents. Web-Cat version
		currently displays program-created representative Rects in lieu of
		images to display.
	
	There are several chunks of code that have been commented out, rather 
		than deleted, most notably in NyanCatView.onDaw, and
		NyanCatView.drawObj. These particular chunks were used to display
		Debug Strings of GameData, and were, frankly, too valuable to scrap
		entirely, as we are still actively using them to visually test our
		application.
		
	There is a method, Map.genPlatforms(), that surely trips a couple styling
		errors solely due to its length. This method is where we generate 
		our map, and cannot be refactored to any smaller length. 