package tepigmc.wealthofnations.tiles;

import java.awt.Graphics;
import java.io.FileNotFoundException;

import tepigmc.common.Coordinates;
import tepigmc.wealthofnations.graphics.Drawable;
import tepigmc.wealthofnations.graphics.ImageFrames;
import tepigmc.wealthofnations.graphics.ImageGraphic;
import tepigmc.wealthofnations.graphics.ImageLayered;
import tepigmc.wealthofnations.graphics.ImagePositioned;

public class IndustryTile extends Tile implements Drawable {

  protected ImageLayered background;
  protected ImageFrames dotRotations;
  protected int rotation;

  public IndustryTile(String name) {
    super(name, name.toLowerCase().replace(' ', '_'));
    setBackground(new ImageLayered());
    setDotRotations(new ImageFrames());
    try {
      ImageFrames frames = new ImageFrames();
      frames.loadImages("tiles/industry_tiles/" + nameId, "back", "png");
      background.addImage(frames);
      background.addImage(new ImageGraphic("tiles/industry_tiles/border_75.png"));
      background.addImage(new ImagePositioned(new ImageGraphic(
          "tiles/automation_token.png"), new Coordinates(21, 24)));
      dotRotations.loadImages("tiles/industry_tiles/" + nameId, "dots", "png");
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    setRotation(0);
  }

  /**
   * @return the background
   */
  public ImageLayered getBackground() {
    return background;
  }

  /**
   * @return the dots
   */
  public ImageFrames getDotRotations() {
    return dotRotations;
  }

  /**
   * @return the rotation
   */
  public int getRotation() {
    return rotation;
  }

  /**
   * @param background the background to set
   */
  public void setBackground(ImageLayered background) {
    this.background = background;
  }

  /**
   * @param dotRotations the dot rotations to set
   */
  public void setDotRotations(ImageFrames dotRotations) {
    this.dotRotations = dotRotations;
  }

  /**
   * @param rotation the rotation to set
   */
  public void setRotation(int rotation) {
    this.rotation = rotation;
    dotRotations.setCurrentFrameIndex(rotation);
  }

  /**
   * @param index the index of the dot rotation
   * @return the dot rotation layer at index
   */
  public Drawable getDotRotation(int index) {
    return dotRotations.getImage(index);
  }

  /**
   * @param index the index of the dot rotation
   * @return the dot rotation at index
   */
  public Drawable getCurrentDotRotation() {
    return getDotRotation(rotation);
  }

  /**
   * Creates a sprite to draw this tile
   * @return the generated sprite
   */
  public ImageLayered toImage() {
    ImageLayered sprite = new ImageLayered((Drawable) background);
    sprite.addImage(dotRotations);
    return sprite;
  }

  /**
   * Draws this tile in the graphics
   * @param graphics the graphics to draw in
   * @param x the horizontal coordinate to draw at
   * @param y the vertical coordinate to draw at
   */
  public void draw(Graphics graphics, int x, int y) {
    toImage().draw(graphics, x, y);
  }

  /**
   * Draws this tile in the graphics
   * @param graphics the graphics to draw in
   * @param coordinates the coordinates to draw at
   */
  public void draw(Graphics graphics, Coordinates coordinates) {
    toImage().draw(graphics, coordinates);
  }

}
