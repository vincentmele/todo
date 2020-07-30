package com.template.states;

import com.template.contracts.ToDoContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

// *********
// * State *
// *********
@BelongsToContract(ToDoContract.class)
public class ToDoState implements ContractState, LinearState {
    private Party assignedBy;
    private Party assignedTo;
    private String taskDescription;
    private Date dateOfCreation;
    private UniqueIdentifier id;

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return this.id;
    }

    public Party getassignedTo() {
        return this.getassignedTo();
    }

    public void setassignedTo(Party assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Party getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Party assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public ToDoState(Party assignedBy, Party assignedTo, String taskDescription, Date dateOfCreation) {
        this.assignedBy = assignedBy;
        this.assignedTo = assignedTo;
        this.taskDescription = taskDescription;
        this.dateOfCreation = dateOfCreation;
        this.id = new UniqueIdentifier();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id.toString());
        sb.append("\n");
        sb.append(this.assignedBy.toString());
        sb.append("\n");
        sb.append(this.assignedTo.toString());
        sb.append("\n");
        sb.append(this.taskDescription);
        sb.append("\n");
        sb.append(this.dateOfCreation.toString());
        return sb.toString();
    }

    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(this.assignedTo, this.assignedBy);
    }
}