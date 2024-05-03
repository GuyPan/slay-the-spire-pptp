package pptpinsts.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import pptpinsts.actions.HellShakeLoseHPAction;
import pptpinsts.util.CustomTags;

import static pptpinsts.BasicMod.makeID;

public class PopukoFormPower extends BasePower{
    public static final String POWER_ID = makeID("PopukoFormPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    private static final boolean INIT_DESCRIPTION = true;
    private static final boolean LOAD_IMAGE = true;

    //The only thing TURN_BASED controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if their amount is positive or negative.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public PopukoFormPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    public void onCardDraw(AbstractCard card) {
        if (card.hasTag(CustomTags.Popuko)) {
            card.setCostForTurn(-9);
        }
    }

}