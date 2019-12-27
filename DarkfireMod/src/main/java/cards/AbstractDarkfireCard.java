package cards;

import basemod.abstracts.CustomCard;
import character.AbstractCardEnum;

public abstract class AbstractDarkfireCard extends CustomCard {
  private static CardColor COLOR = AbstractCardEnum.DARKFIRE_COLOR;
  public AbstractDarkfireCard(String id, String name, String img_path, int cost, String description, CardType type, CardRarity rarity, CardTarget target) {
    super(id, name, img_path, cost, description, type, COLOR, rarity, target);
  }
}
