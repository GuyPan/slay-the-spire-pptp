package pptpinsts.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pptpinsts.cards.BaseCard;
import pptpinsts.character.Poppuko;
import pptpinsts.powers.HellShakeByNerf;

public class PptpHellShakeByNerf extends BaseCard {
    public static final String ID = makeID(PptpHellShakeByNerf.class.getSimpleName());

    private static final int MAGIC = 5; //Default
    private static final int UPG_MAGIC = 2; //Upgrade

    public PptpHellShakeByNerf() {
        super(ID, 0, CardType.POWER, CardTarget.SELF,CardRarity.RARE, Poppuko.Meta.CARD_COLOR);
        this.baseMagicNumber = 5;
        this.magicNumber = this.baseMagicNumber;
        setMagic(MAGIC,UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new HellShakeByNerf(p, this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new PptpHellShakeByNerf();
    }
}
