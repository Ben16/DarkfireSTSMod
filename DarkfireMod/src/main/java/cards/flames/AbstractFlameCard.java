package cards.flames;

import com.megacrit.cardcrawl.cards.AbstractCard;

import basemod.abstracts.CustomCard;
import character.AbstractCardEnum;

public abstract class AbstractFlameCard extends CustomCard {
  private static CardColor COLOR = CardColor.COLORLESS;
  public AbstractFlameCard(String id, String name, String img_path, int cost, String description, CardType type, CardRarity rarity, CardTarget target) {
    super(id, name, img_path, cost, description, type, COLOR, rarity, target);
  }
}
