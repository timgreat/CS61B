package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    public static void addHexagon(TETile[][] world,int s,int posX,int posY,TETile name){
        int WIDTH=3*s-2,HEIGHT=2*s;
        int i=0,j=0;
        for (j=0;j<s;j++){
            for(i=0;i<WIDTH;i++){
                if(s-j-1<=i&&i<2*s+j-1)
                    world[i+posX][j+posY]=name;
            }
        }
        for (j=s;j<HEIGHT;j++){
            for(i=0;i<WIDTH;i++){
                if(j-s<=i&&i<4*s-j-2)
                    world[i+posX][j+posY]=name;
            }
        }
    }

    public static void main(String[] args) {
        TERenderer ter=new TERenderer();
        ter.initialize(60,60);
        TETile[][] world = new TETile[60][60];
        int i=0;
        int j=0;
        for(i=0;i<60;i++){
            for(j=0;j<60;j++){
                world[i][j]=Tileset.NOTHING;
            }
        }
        addHexagon(world,3, 27, 0, TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()));
        addHexagon(world,3, 27, 6, TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()));
        addHexagon(world,3, 27, 12, TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()));
        addHexagon(world,3, 27, 18, TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()));
        addHexagon(world,3, 27, 24, Tileset.TREE);

        addHexagon(world,3, 22, 3, Tileset.FLOWER);
        addHexagon(world,3, 22, 9,TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()) );
        addHexagon(world,3, 22, 15,TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()) );
        addHexagon(world,3,22,21,Tileset.GRASS);

        addHexagon(world,3,17,6,Tileset.GRASS);
        addHexagon(world,3,17,12,Tileset.GRASS);
        addHexagon(world,3,17,18,TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()));

        addHexagon(world,3,32,3,TETile.colorVariant(Tileset.MOUNTAIN, 40, 40, 40, new Random()));
        addHexagon(world,3,32,9,Tileset.TREE);
        addHexagon(world,3,32,15,TETile.colorVariant(Tileset.SAND, 40, 40, 40, new Random()));
        addHexagon(world,3,32,21,Tileset.FLOWER);

        addHexagon(world,3,37,6,TETile.colorVariant(Tileset.SAND, 40, 40, 40, new Random()));
        addHexagon(world,3,37,12,Tileset.TREE);
        addHexagon(world,3,37,18,Tileset.FLOWER);

        ter.renderFrame(world);
    }
}
