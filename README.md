## Assignment 2 - grade 4

Group members:
- Anna Manole

For this project I used swing as a framework for Java. Initially I had problems with having the path of resources work. They should have been placed in src/main/resources and then use the command gradle clean build. Took a long time to get it to work. I also had to rename all my images so that I don't refactor the model.

Displaying the images was no problem, however animating it went through several failed itterations. I am assuming that it has to do with repainting the panel all the time, but I could not get it to work. I ended up just adding sound on card draw.

I don't think implementing the View interface was optimal, considering I'm overriding the methods in the view class. I would have liked to have a separate class for the view, but then I would have had to rewrite the Player controller. I kept the overridden methods in the WindowView class and use them as a way to debug at the terminal.

