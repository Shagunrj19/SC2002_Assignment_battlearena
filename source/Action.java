import java.util.List;

public interface Action {
    /**
     * @param source The combatant performing the action
     * @param targets The list of target
     */
    void execute(Combatant source, List<Combatant> targets);
}
