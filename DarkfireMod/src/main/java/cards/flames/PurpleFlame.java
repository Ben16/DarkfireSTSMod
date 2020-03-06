package cards.flames;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class PurpleFlame extends AbstractFlameCard {
  private static final String ID = "darkfire:PurpleFlame";
  private static final String IMG_PATH = "cards/flames/purple_flame.png";
  private static final int COST = 0;
  private static final CardType TYPE = CardType.STATUS;
  private static final CardRarity RARITY = CardRarity.BASIC;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int DAMAGE = 6;

  public PurpleFlame() {
    super(ID, IMG_PATH, COST, TYPE, RARITY, TARGET);
    this.damage = this.baseDamage = DAMAGE;
    this.exhaust = true;
    this.isEthereal = true;
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
