package pptpinsts.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pptpinsts.cards.BaseCard;
import pptpinsts.character.Poppuko;
import pptpinsts.powers.Kuso;
import pptpinsts.util.CardStats;

public class PptpKuso extends BaseCard {
    public static final String ID = makeID(PptpKuso.class.getSimpleName());
    private static final CardStats info = new CardStats(
            Poppuko.Meta.CARD_COLOR, //The card color. If you're making your own character, it'll look something like this. Otherwise, it'll be CardColor.RED or something similar for a basegame character color.
            CardType.POWER, //The type. ATTACK/SKILL/POWER/CURSE/STATUS
            CardRarity.UNCOMMON, //Rarity. BASIC is for starting cards, then there's COMMON/UNCOMMON/RARE, and then SPECIAL and CURSE. SPECIAL is for cards you only get from events. Curse is for curses, except for special curses like Curse of the Bell and Necronomicurse.
            CardTarget.ENEMY, //The target. Single target is ENEMY, all enemies is ALL_ENEMY. Look at cards similar to what you want to see what to use.
            1 //The card's base cost. -1 is X cost, -2 is no cost for unplayable cards like curses, or Reflex.
    );

    private static final int MAGIC = 996; //Default
    private static final int UPG_MAGIC = 3; //Upgrade

    public PptpKuso() {
        super(ID, info); //Pass the required information to the BaseCard constructor.
        //tags.add(BaseModCardTags.FORM);
        setMagic(MAGIC,UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new Kuso(m, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new PptpKuso();
    }

}
