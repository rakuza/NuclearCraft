package nc.multiblock.network;

import io.netty.buffer.ByteBuf;
import nc.multiblock.heatExchanger.HeatExchanger;
import nc.multiblock.heatExchanger.tile.TileHeatExchangerController;
import net.minecraft.util.math.BlockPos;

public class HeatExchangerUpdatePacket extends MultiblockUpdatePacket {
	
	protected boolean isHeatExchangerOn;
	public double fractionOfTubesActive;
	public double efficiency;
	
	public HeatExchangerUpdatePacket() {
		messageValid = false;
	}
	
	public HeatExchangerUpdatePacket(BlockPos pos, boolean isHeatExchangerOn, double fractionOfTubesActive, double efficiency) {
		this.pos = pos;
		this.isHeatExchangerOn = isHeatExchangerOn;
		this.fractionOfTubesActive = fractionOfTubesActive;
		this.efficiency = efficiency;
		
		messageValid = true;
	}
	
	@Override
	public void readMessage(ByteBuf buf) {
		pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		isHeatExchangerOn = buf.readBoolean();
		fractionOfTubesActive = buf.readDouble();
		efficiency = buf.readDouble();
	}
	
	@Override
	public void writeMessage(ByteBuf buf) {
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		buf.writeBoolean(isHeatExchangerOn);
		buf.writeDouble(fractionOfTubesActive);
		buf.writeDouble(efficiency);
	}
	
	public static class Handler extends MultiblockUpdatePacket.Handler<HeatExchangerUpdatePacket, HeatExchanger, TileHeatExchangerController> {

		public Handler() {
			super(TileHeatExchangerController.class);
		}
		
		@Override
		protected void onPacket(HeatExchangerUpdatePacket message, HeatExchanger reactor) {
			reactor.onPacket(message.isHeatExchangerOn, message.fractionOfTubesActive, message.efficiency);
		}
	}
}
