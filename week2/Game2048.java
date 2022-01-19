import java.util.Scanner;

public class Game2048 {
    public static void main(String ... args) {
	  Scanner in = new Scanner(System.in);
	  int grid[][] = new int[4][4];
	  for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
		    grid[i][j] = in.nextInt();
		}
	  }
	  int button = in.nextInt();
	  if(button == 0) {
		for(int i = 0; i < 4; i++) {
                int temp = -1;
                for(int j = 0; j < 4; j++) {
                    if (grid[i][j] != 0) {
                        if (temp != -1 && grid[i][temp] == grid[i][j]) {
                            grid[i][temp] += grid[i][j];    
                            grid[i][j] = 0;
                            temp = -1;
                        } else {
                            temp = j;
				}
                    }
                }
                for(int j = 0; j < 4; j++) {
                    if(grid[i][j] != 0) {
                        continue;
			  }
                    for(int k = j; k < 4; k++) {
                        if(grid[i][k] != 0) {
                            grid[i][j] = grid[i][k];
                            grid[i][k] = 0;
                            break;
                        }
			  }
                }
            }
	  } else if(button == 1) {
		for(int j = 0; j < 4; j++) {
                int temp = -1;
                for(int i = 0; i < 4; i++) {
                    if (grid[i][j] != 0) {
                        if (temp != -1 && grid[temp][j] == grid[i][j]) {
                            grid[temp][j] += grid[i][j];    
                            grid[i][j] = 0;
                            temp = -1;
                        } else {
                            temp = i;
				}
                    }
                }
                for(int i = 0; i < 4; i++) {
                    if(grid[i][j] != 0) {
                        continue;
			  }
                    for(int k = i; k < 4; k++) {
                        if(grid[k][j] != 0) {
                            grid[i][j] = grid[k][j];
                            grid[k][j] = 0;
                            break;
                        }
			  }
                }
            }
	  } else if(button == 2) {
		for(int i = 3; i >= 0; i--) {
                int temp = -1;
                for(int j = 3; j >= 0; j--) {
                    if (grid[i][j] != 0) {
                        if (temp != -1 && grid[i][temp] == grid[i][j]) {
                            grid[i][temp] += grid[i][j];    
                            grid[i][j] = 0;
                            temp = -1;
                        } else {
                            temp = j;
				}
                    }
                }
                for(int j = 3; j >= 0; j--) {
                    if(grid[i][j] != 0) {
                        continue;
			  }
                    for(int k = j; k >= 0; k--) {
                        if(grid[i][k] != 0)
                        {
                            grid[i][j] = grid[i][k];
                            grid[i][k] = 0;
                            break;
                        }
			  }
                }
            }
	  } else if(button == 3) {
		for(int j = 3; j >= 0; j--) {
                int temp = -1;
                for(int i = 3; i >= 0; i--) {
                    if (grid[i][j] == 0) {
                        continue;
			  } else {
                        if (temp != -1 && grid[temp][j] == grid[i][j])
                        {
                            grid[temp][j] += grid[i][j];    
                            grid[i][j] = 0;
                            temp = -1;
                        } else {
                            temp = i;
				}
                    }
                }
                temp = -1;
                for(int i = 3; i >= 0; i--) {
                    if(grid[i][j] != 0) {
                        continue;
			  }
                    for(int k = i; k >= 0; k--) {
                        if(grid[k][j] != 0) {
                            grid[i][j] = grid[k][j];
                            grid[k][j] = 0;
                            break;
                        }
			  }
                }
            }
	  }
	  for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
		    System.out.print(grid[i][j] + " ");
		}
		System.out.println();
	  }
    }
}