package cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import actions.FlareStormAction;

public class FlareStorm extends AbstractDarkfireCard {

  private static final String ID = "darkfire:FlareStorm";
  private static final String IMG_PATH = "cards/flare_storm.png";
  private static final int COST = -1;
  private static final CardType TYPE = CardType.ATTACK;
  private static final CardRarity RARITY = CardRarity.UNCOMMON;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int DAMAGE = 2;
  private static final int FLAME_DRAW = 1;
  private static final int ENERGY_ON_USE = -1;

  public FlareStorm() {
    super(ID, IMG_PATH, COST, TYPE, RARITY, TARGET);
    this.damage = this.baseDamage = DAMAGE;
    this.isMultiDamage = true;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new FlareStormAction(p, m, this.damage, FLAME_DRAW, this.damageTypeForTurn, false, ENERGY_ON_USE));
  }

  private static final int UPGRADE_DAMAGE = 2;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      this.upgradeName();
      this.upgradeDamage(UPGRADE_DAMAGE);
    }
  }
}
