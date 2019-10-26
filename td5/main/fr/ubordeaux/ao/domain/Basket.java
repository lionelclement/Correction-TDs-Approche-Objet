package fr.ubordeaux.ao.domain;

import java.util.Map;
import java.util.HashMap;

/**
 * Aggregate
 * 
 **/
public class Basket {
    private static int nextId;
    private int id;
    private Map<Reference, CommandLine> commandLineMap;
    private boolean isClosed;

    public Basket() {
        this.id = ++nextId;
        commandLineMap = new HashMap<Reference, CommandLine>();
        isClosed = false;
    }

    public void order(Reference reference, int quantity) {
        if (!isClosed) {
            if (commandLineMap.containsKey(reference)) {
                commandLineMap.get(reference).changeQuantity(quantity);
            } else {
                CommandLine cl = new CommandLine(reference, quantity);
                commandLineMap.put(reference, cl);
            }
        }
    }

    public int getId() {
		return id;
	}

	public void remove(Reference reference) {
        if (!isClosed) {
            if (commandLineMap.containsKey(reference)) {
                commandLineMap.remove(reference);
            }
        }
    }

    public void close() {
        isClosed = true;
    }

    public Price getPrice() {
        int price = 0;
        for (CommandLine line : commandLineMap.values()) {
            price += line.getPrice().getValue();
        }
        return new Price(price);
    }

    
}