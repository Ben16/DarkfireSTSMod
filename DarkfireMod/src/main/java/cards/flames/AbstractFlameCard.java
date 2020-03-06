package cards.flames;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;

import basemod.abstracts.CustomCard;
import character.AbstractCardEnum;

public abstract class AbstractFlameCard extends CustomCard {
  private static CardColor COLOR = CardColor.COLORLESS;
  public AbstractFlameCard(String id, String img_path, int cost, CardType type, CardRarity rarity, CardTarget target) {
    super(id, CardCrawlGame.languagePack.getCardStrings(id).NAME, img_path, cost, CardCrawlGame.languagePack.getCardStrings(id).DESCRIPTION, type, COLOR, rarity, target);
  }
}
