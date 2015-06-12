package tepigmc.wealthofnations.tiles;

import tepigmc.common.RandomUtil;

public class FarmTile extends IndustryTile {

  public FarmTile() {
    super("Farm");
    setRotation(RandomUtil.randInt(0, 5));
  }

}
