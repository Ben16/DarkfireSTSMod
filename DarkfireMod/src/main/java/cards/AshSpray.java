package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class AshSpray extends AbstractDarkfireCard {
  private static final String ID = "darkfire:AshSpray";
  private static final String NAME = "Ash Spray";
  private static final String IMG_PATH = "cards/ash_spray.png";
  private static final int COST = 1;
  private static final String DESCRIPTION = "Deal 2 damage 4 times.";
  private static final CardType TYPE = CardType.ATTACK;
  private static final CardRarity RARITY = CardRarity.COMMON;
  private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
  private static final int DAMAGE = 1;
  private static int ATTACK_TIMES = 4;

  public AshSpray() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.damage = this.baseDamage = DAMAGE;
    this.magicNumber = this.baseMagicNumber = ATTACK_TIMES;

    this.isMultiDamage = true;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    for (int i = 0; i < this.magicNumber - 1; ++i) {
      AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE, true));
    }
    AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE, true));
  }

  private static int UPGRADE_DAMAGE = 2;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(UPGRADE_DAMAGE);
    }
  }

}
