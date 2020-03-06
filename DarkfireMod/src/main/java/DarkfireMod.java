import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;

import java.util.ArrayList;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;

import basemod.interfaces.EditStringsSubscriber;
import character.AbstractCardEnum;
import character.DarkfireCharacter;
import character.DarkfireEnum;

@SpireInitializer
public class DarkfireMod implements EditCardsSubscriber, EditCharactersSubscriber, EditStringsSubscriber {
  public static final Color EVERYTHING_COLOR = new Color(0, 0, (float)0.54, 1);
  public DarkfireMod() {
    BaseMod.addColor(AbstractCardEnum.DARKFIRE_COLOR, EVERYTHING_COLOR,
            "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/card_orb.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png", "card_bg/attack_bg.png", "character/energy_orb.png", "character/energy_orb.png");
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

  @Override
  public void receiveEditStrings() {
    BaseMod.loadCustomStringsFile(CardStrings.class, "strings/english/cards.json");
    BaseMod.loadCustomStringsFile(CharacterStrings.class, "strings/english/character.json");
  }
}
