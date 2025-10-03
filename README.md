# The Hotdog Game

## Background

This game has been a meaningless school project implemented by two German high school
students, Dennis Simontowsky ([@Userdennis](https://github.com/Userdennis)) and me.

## Description

In this desktop game you are playing a dog which needs to collect sausages in stalls
to protect himself against herbal enemies. Further, he needs to escape the ketchup
sprinkles of death.

The game offers different difficulty levels. The higher the difficulty, the less the
time in which you need to complete the level, and the more other obstacles ;) 

## Implementation notes

Since this project has not been maintained the last years, the source code has received
a little overhaul, but we're not yet there that it's a readable and maintainable codebase:

- The code is still quite upside-down code, which is just what you get when a few
  students without any practical experience start writing code that "just works" but
  is... ehm... yes, upside-down.
- Most javadoc comments are useless and still in German.
- We are depending on a really ancient `engine-alpha` version. Upgrading to EA4
  or migrating another mature game library would possibly be a great idea.
- I'm not sure about whether we are there yet to run this on cross-platform.
  As far as I remember, EA3 has no platform-specific assumptions, but I cannot
  promise it works on any machine.
- There are neither tests nor a build and release pipeline.  
