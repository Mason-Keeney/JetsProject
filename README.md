# JetsProject

### Week 3 Weekend Project Skill Distillery

##Overview
The JetsApplication software allows a user to scroll through 2 different menus with a variety of choices. There are 6 options in the first menu:
1. View Jet Menu
2. DOGFIIIIIIIIGHT!!
3. Hire a new Pilot
4. Show Menu
5. Print a copy
6. Quit

Inside of the Jet Menu, there are a further 10 total options, but I will leave off the Show Menu and Return to Main Menu Options
1. List Jets in Airfield
2. Fly a Jet
3. Fly all Jets
4. View the Fastest
5. View the highest Range
6. Load all Cargo Jets
7. Add a Jet
8. Remove a Jet

When selected, the various options will prompt the user for additional information if needed, or execute on any Jets able to execute the requested option (i.e. non-CargoPlanes will not Load Cargo). While there is only one jet-type capable of the two interfaces currently, the software is written as such that new jets could be added that implement these interfaces if desired.

## Technologies/Skills Used

* Java
* Eclipse
* Git
* GitHub
* Terminal

## Lessons Learned
This was, by far and above, the most complex project we've worked on so far, both in the size and variety of Java tools used (that import list keeps growing longer!) Keeping the code DRY was definitely hard on this[^note]. I'll have to look back on this project in a few months to see if I can actually track my logic. The way I designed this software was starting with the Objects, then the Menus, which forced me to generate the methods I would eventually need, then write the method bodies, then refine. While this did make my end goals very clear, it also lead to some... interesting... duplication of methods. These were (for the most part at least) caught and dealt with in the refining stage, but on an even larger project that may not work, so while I am happy with the result, I do think better planning would have helped in this instance. I think I may try to learn how to create a UML and how to create efficient JUnit tests for future projects to help me plan in the future. I believe that would allow me to create easily-read, portable, and DRY programs in the future.

[^note]: please let me know how this code looks in terms of readability. I would like to know if I'm nearing obfuscated c levels of confusion in there. 