# Rose

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Rose-green.svg?style=flat )]( https://android-arsenal.com/details/1/7226 )


Show Android log in the best way, easy to debug.

 
 This is a logger with a small which provides utility on top of Android's normal
 `Log` class.
 
 I copy this class into all the little apps I make. I'm tired of doing it. Now it's a library.
 

            
 The `Rose`  will automatically figure out from which class it's being called and
 use that class name as its tag.

 
 
 Usage
 -----
 
 Two easy steps:
 
  1. Enable debug mode in the `onCreate` of your application class.
  
             Rose.debugEnabled(BuildConfig.DEBUG)                                  
  2. Call `Rose`'s static methods everywhere throughout your app.
 
             Rose.debug("this is the very first log")
             Rose.error("this is the very first log")
             
        It will show as below:
    
             I/Rose: net.fitken.rosesample.MainActivity.onCreate   
             D/Rose: this is the very first log
             I/Rose: net.fitken.rosesample.MainActivity.onCreate(MainActivity.kt:14)
             E/Rose: this is the very first log

 

 
 
 Download
 --------
             implementation 'net.fitken:rose:1.0.2'
 
 
 

