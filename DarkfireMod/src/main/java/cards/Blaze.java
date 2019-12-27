package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Blaze extends AbstractDarkfireCard {
  private static final String ID = "darkfire:Blaze";
  private static final String NAME = "Blaze";
  private static final String IMG_PATH = "cards/blaze.png";
  private static final int COST = 1;
  private static final String DESCRIPTION = "Gain 4 Strength and lose 1 Dexterity.";
  private static final CardType TYPE = CardType.POWER;
  private static final CardRarity RARITY = CardRarity.UNCOMMON;
  private static final CardTarget TARGET = CardTarget.SELF;
  private static final int STRENGTH = 4;
  private static final int DEXTERITY = -1;

  public Blaze() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.magicNumber = this.baseMagicNumber = STRENGTH;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new DexterityPower(p, this.DEXTERITY), this.magicNumber));
  }

  private static int UPGRADE_STRENGTH = 1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(UPGRADE_STRENGTH);
    }
  }
}
