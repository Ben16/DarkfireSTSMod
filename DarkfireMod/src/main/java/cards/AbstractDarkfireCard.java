package cards;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;

import basemod.abstracts.CustomCard;
import character.AbstractCardEnum;

public abstract class AbstractDarkfireCard extends CustomCard {
  private static CardColor COLOR = AbstractCardEnum.DARKFIRE_COLOR;
  public AbstractDarkfireCard(String id, String img_path, int cost, CardType type, CardRarity rarity, CardTarget target) {
    super(id, CardCrawlGame.languagePack.getCardStrings(id).NAME, img_path, cost, CardCrawlGame.languagePack.getCardStrings(id).DESCRIPTION, type, COLOR, rarity, target);

  }
}
