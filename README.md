## life
A simulator for the Game of Life

## How to use:

The game is written in Java, with the source in `src/` and a binary in `bin/`.
Call the game using the `LifeSimulator` class. Further instructions can be found inside the program by typing `HELP`. The game can also be called using 2 optional files, one for the input and one for the output, as such:
```
 java LifeSimulator path/to/input.file path/to/output.file
```

## Game:

[https://en.wikipedia.org/wiki/Conway's_Game_of_Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life)

The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970. The game has an infinite map of cells, which all start out dead. On each step, cells change their status based on the following rules: 

1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by over-population.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
