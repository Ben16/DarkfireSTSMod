package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import actions.ExhaustRandom;
import cards.AbstractDarkfireCard;

public class BurningShot extends AbstractDarkfireCard {
  private static final String ID = "darkfire:BurningShot";
  private static final String NAME = "Burning Shot";
  private static final String IMG_PATH = "cards/burning_shot.png";
  private static final int COST = 1;
  private static final String DESCRIPTION = "Deal 15 damage and exhaust 1 random card in your hand.";
  private static final CardType TYPE = CardType.ATTACK;
  private static final CardRarity RARITY = CardRarity.COMMON;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int DAMAGE = 15;
  private static final int EXHAUST_COUNT = 1;

  public BurningShot() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.damage = this.baseDamage = DAMAGE;
    this.magicNumber = this.baseMagicNumber = EXHAUST_COUNT;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
    AbstractDungeon.actionManager.addToBottom(new ExhaustRandom(p, p, this.magicNumber));
  }

  private static int UPGRADE_DAMAGE = 4;

  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(UPGRADE_DAMAGE);
    }
  }
}
