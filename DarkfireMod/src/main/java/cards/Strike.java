package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Strike extends AbstractDarkfireCard {

  private static final String ID = "darkfire:Strike";
  private static final String NAME = "Strike";
  private static final String IMG_PATH = "cards/strike.png";
  private static final int COST = 1;
  private static final String DESCRIPTION = "Deal 6 damage.";
  private static final CardType TYPE = CardType.ATTACK;
  private static final CardRarity RARITY = CardRarity.BASIC;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int DAMAGE = 6;

  public Strike() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.damage = this.baseDamage = DAMAGE;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
  }

  private static int UPGRADE_DAMAGE = 3;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(UPGRADE_DAMAGE);
    }
  }
}
