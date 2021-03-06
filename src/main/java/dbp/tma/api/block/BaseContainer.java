package dbp.tma.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BaseContainer extends BlockChest{
	boolean isOpaque = true;
	boolean isNormal = true;
	int renderType = 0;

	public BaseContainer(int trapped) {
		super(trapped);
	}
	
	//@Override
    //public int getRenderType(){
    //    return renderType;
    //}

	@Override
	public TileEntity createNewTileEntity(World world, int unknown) {
        TileBase tile = new TileBase();
        return tile;
	}
	
	//@Override
    //public boolean isOpaqueCube(){
    //    return isOpaque;
    //}
    
	//@Override
    //public boolean renderAsNormalBlock(){
    //    return isNormal;
    //}
	
	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        super.onNeighborBlockChange(world, x, y, z, block);
        TileBase tile = (TileBase)world.getTileEntity(x, y, z);

        if (tile != null){
        	tile.updateContainingBlockInfo();
        }
    }
	
	//@Override public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){}

}
