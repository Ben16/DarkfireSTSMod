import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;

@SpireInitializer
public class DarkfireMod implements EditCardsSubscriber, EditCharactersSubscriber {
  public static final Color EVERYTHING_COLOR = new Color(0, 0, (float)0.54, 1);
  public DarkfireMod() {
    BaseMod.addColor(AbstractCardEnum.DARKFIRE_COLOR, EVERYTHING_COLOR,
            "character/button.png", "character/button.png", "character/button.png", "character/button.png", "character/button.png", "character/button.png", "character/button.png", "character/button.png", "character/button.png");
    BaseMod.subscribe(this);
  }

  public static void initialize() {
    new DarkfireMod();
  }

  @Override
  public void receiveEditCards() {
    //TODO
  }

  @Override
  public void receiveEditCharacters() {
    //TODO
    BaseMod.addCharacter(new DarkfireCharacter("Darkfire"), "character/button.png",
            "character/darkfire.png", DarkfireEnum.DARKFIRE);
  }
}
