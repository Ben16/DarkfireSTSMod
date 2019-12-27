import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import cards.AshSpray;
import cards.Blaze;
import cards.Defend;
import cards.EmberShell;
import cards.Strike;
import cards.WheelingFlame;
import character.AbstractCardEnum;
import character.DarkfireCharacter;
import character.DarkfireEnum;

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
    BaseMod.addCard(new Strike());
    BaseMod.addCard(new Defend());
    BaseMod.addCard(new EmberShell());
    BaseMod.addCard(new AshSpray());
    BaseMod.addCard(new Blaze());
    BaseMod.addCard(new WheelingFlame());
  }

  @Override
  public void receiveEditCharacters() {
    BaseMod.addCharacter(new DarkfireCharacter("Darkfire"), "character/button.png",
            "character/darkfire.png", DarkfireEnum.DARKFIRE);
  }
}
