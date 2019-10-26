package fr.ubordeaux.ao.domain;

/**
 * Value Object
 */
public class Reference {
    private static int nextId;
    private int id;
    private ReferenceName name;
    private String description;
    private Price price;

    public Reference(int id, ReferenceName name, String description, Price price) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (description == null) {
            throw new IllegalArgumentException();
        }
        if (price == null) {
            throw new IllegalArgumentException();
        }
        if (description.length() >= 200) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Reference(ReferenceName name, String description, Price price) {
        this(++nextId, name, description, price);
    }

    public int getId() {
        return this.id;
    }

    public ReferenceName getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Price getPrice() {
        return this.price;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reference other = (Reference) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}