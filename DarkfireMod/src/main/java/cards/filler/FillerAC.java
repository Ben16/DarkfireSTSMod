package cards.filler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import cards.AbstractDarkfireCard;

public class FillerAC extends AbstractDarkfireCard {
  private static final String ID = "darkfire:FillerAC";
  private static final String NAME = "Filler";
  private static final String IMG_PATH = "cards/filler.png";
  private static final int COST = 1;
  private static final String DESCRIPTION = "Filler text.";
  private static final CardType TYPE = CardType.ATTACK;
  private static final CardRarity RARITY = CardRarity.COMMON;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int DAMAGE = 1;

  public FillerAC() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.damage = this.baseDamage = DAMAGE;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
  }

  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
    }
  }
}
