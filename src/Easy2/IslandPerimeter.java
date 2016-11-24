package Easy2;

/**
 * 463题     岛屿的边数
 * Created by ly on 2016/11/24.
 */
public class IslandPerimeter {
    /*
    I was giving this pattern a lot of thought. The most intuitive way I could understand it was this.

Each island or cell has 4 sides and to get the total potential number of sides you would need to multiply the total number of islands by 4. Easy enough...

For the subtraction half...

Let's define what a side can possibly mean.
(1) A side that belongs to the perimeter count is required to belong to only one island.
(2) A side which is not included in the perimeter count is a side that belongs to two islands.

We are looking for a side that satisfies two requirements -
(a) It's a side of an island
(b) It's a side that belongs to only one island (see #1)

Why check only right and down neighbors?
The reason why the above solution checks the right and down neighbors because it prevents counting or checking a side twice (go ahead and visually try it).

Why multiply neighbors by 2?
We are checking if a side is #2. The side is shared by two islands and so we have to multiply the neighbors by two.

    */
    //198ms
    public int islandPerimeter(int[][] grid) {
        int neighbours = 0;
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    islands++;
                    if(i < grid.length-1 && grid[i+1][j] == 1)
                        neighbours++;   //右邻居
                    if(j < grid[i].length-1 && grid[i][j+1] == 1)
                        neighbours++;   //左邻居
                }
            }
        }
        return islands*4-neighbours*2;
    }
}
