import java.util.List;

public class Defend implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        // Boost defense for 2 rounds
        DefenseBoost effect = new DefenseBoost();
        source.addStatusEffect(effect);
    }
}
