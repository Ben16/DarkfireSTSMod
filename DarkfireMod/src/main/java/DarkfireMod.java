import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import cards.AshSpray;
import cards.Blaze;
import cards.BurningShot;
import cards.Defend;
import cards.EmberShell;
import cards.Strike;
import cards.WheelingFlame;
import cards.filler.FillerAC;
import cards.filler.FillerAU;
import cards.filler.FillerPC;
import cards.filler.FillerPR;
import cards.filler.FillerSR;
import cards.filler.FillerSU;
import character.AbstractCardEnum;
import character.DarkfireCharacter;
import character.DarkfireEnum;

@SpireInitializer
public class DarkfireMod implements EditCardsSubscriber, EditCharactersSubscriber {
  public static final Color EVERYTHING_COLOR = new Color(0, 0, (float)0.54, 1);
  public DarkfireMod() {
    // change the images so the cards look right
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
    BaseMod.addCard(new BurningShot());

    // filler cards to get the game to run
    BaseMod.addCard(new FillerAU());
    BaseMod.addCard(new FillerPC());
    BaseMod.addCard(new FillerPR());
    BaseMod.addCard(new FillerSR());
    BaseMod.addCard(new FillerSU());
  }

  @Override
  public void receiveEditCharacters() {
    BaseMod.addCharacter(new DarkfireCharacter("Darkfire"), "character/button.png",
            "character/darkfire.png", DarkfireEnum.DARKFIRE);
  }
}
