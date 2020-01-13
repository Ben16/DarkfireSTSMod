import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;

import character.AbstractCardEnum;
import character.DarkfireCharacter;
import character.DarkfireEnum;

@SpireInitializer
public class DarkfireMod implements EditCardsSubscriber, EditCharactersSubscriber {
  public static final Color EVERYTHING_COLOR = new Color(0, 0, (float)0.54, 1);
  public DarkfireMod() {
    // change the images so the cards look right
    BaseMod.addColor(AbstractCardEnum.DARKFIRE_COLOR, EVERYTHING_COLOR,
            "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/card_orb.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png");
    BaseMod.subscribe(this);
  }

  public static void initialize() {
    new DarkfireMod();
  }

  @Override
  public void receiveEditCards() {
    ArrayList<AbstractCard> allCards = util.DarkfireCardList.GetAllCards();
    for (AbstractCard c : allCards) {
      BaseMod.addCard(c);
    }

    ArrayList<AbstractCard> flameCards = util.DarkfireCardList.GetAllFlameCards();
    for (AbstractCard c : flameCards) {
      BaseMod.addCard(c);
    }
  }

  @Override
  public void receiveEditCharacters() {
    BaseMod.addCharacter(new DarkfireCharacter("Darkfire"), "character/button.png",
            "character/darkfire.png", DarkfireEnum.DARKFIRE);
  }
}
