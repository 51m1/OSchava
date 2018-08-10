# OSchava

The project contains four different classes:
- worder.java is meant to solve the first exersise about finding the unique leter in a word.
- nodo.java and list.java are used to make a inked list, my aproach to solving the second problem, about finding the median of a list of     numbers.
- notinlist.java revolves around the third problem, making a list of random numbers within a desired range and randomly finding a number     NOT included in said list.

The project was created and tested using Eclipse Photon for Java.

Performance:
- worder.java: It takes around 450000 ns to solve the problem with short words. It has an n*n complexity (as far as I can tell).
- list.java: It takes user input, calculating the runtime is complicated because of this. For adding new numbers to the list complexity is
  n at best and n*n in the worst case scenario. For calcuating the median we get an n/2 complexity.
- notinlist.java: When tested with an N = 20 and a k = 19, the program took anywhere between 1800000 ans 3200000 ns to reach completion.     As far as I can tell the part of the program that creates the list of numbers has a complexity of n*n.

My personal computer already has problems with memory and CPU management, I couldnt figure out a way to reliablly test the impact of running my code in the resource usage.
