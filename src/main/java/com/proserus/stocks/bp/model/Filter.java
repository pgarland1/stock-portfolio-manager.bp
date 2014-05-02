package com.proserus.stocks.bp.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.jfree.data.time.Year;
import org.joda.time.DateTime;

import com.proserus.stocks.bo.symbols.CurrencyEnum;
import com.proserus.stocks.bo.symbols.SectorEnum;
import com.proserus.stocks.bo.symbols.Symbol;
import com.proserus.stocks.bo.transactions.Label;
import com.proserus.stocks.bo.transactions.TransactionType;

public class Filter{
	private Map<String, Label> labels = new HashMap<String, Label>();

	private Year year = null;//FIXME Year JFree
	
	private TransactionType type = null;
	
	private SectorEnum sector = null;
	
	public SectorEnum getSector() {
    	return sector;
    }

	public void setSector(SectorEnum sector) {
    	this.sector = sector;
    }

	public CurrencyEnum getCurrency() {
    	return currency;
    }

	public void setCurrency(CurrencyEnum currency) {
    	this.currency = currency;
    }

	private CurrencyEnum currency = null;

	public Collection<Label> getLabels() {
		return labels.values();
	}

	public Map<String, Label> getLabelsMap() {
		return labels;
	}

	public void setLabels(Map<String, Label> labels) {
		this.labels = labels;
	}

	public void setYear(Year year) {
		if (year != null) {
			this.year = new Year(year.getYear());
		} else {
			this.year = null;
		}
	}

	public boolean isDateFiltered() {
		return year != null;
	}
	
	public boolean isFiltered(){
		return isDateFiltered() || isSymbolFiltered() || isLabelsFiltered() || isTypeFiltered() || isCurrencyFiltered() || isSectorFiltered();
	}
	
	public boolean isSymbolFiltered() {
		return symbol!=null && !symbol.getTicker().isEmpty();
	}
	
	public boolean isTypeFiltered() {
		return type != null;
	}
	
	public boolean isSectorFiltered() {
		return sector != null;
	}
	
	public boolean isCurrencyFiltered() {
		return currency != null;
	}
	
	public boolean isLabelsFiltered() {
		return !labels.isEmpty();
	}

	public boolean isFilteredYearAfter(DateTime date) {
		//TODO Manage Date better
		return isDateFiltered() && (getYear().getYear() > date.getYear());
	}
	
	public void setTransactionType(TransactionType type){
		this.type = type;
	}
	

	public TransactionType getTransactionType() {
    	return type;
    }

	public Year getYear() {
		return year;
	}
	
	public void addLabel(Label label) {
		this.labels.put(label.getName(), label);
	}

	public void removeLabel(Label label) {
		this.labels.remove(label.getName());
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	private Symbol symbol = null;

	public String toString() {
		String str = "";
		String labelsStr = labels.values().toString();
		if (labelsStr.compareTo("[]") == 0) {
			labelsStr = "[   ]";
		}

		if (year != null) {
			str += "        Year: [" + year.getYear() + "]";
		} else {
			str += "        Year: [   ]";
		}

		if (symbol != null) {
			str += "        Symbol: [" + getSymbol().getTicker() + "]";
		} else {
			str += "        Symbol: [   ]";
		}

		str += "        Labels: " + labelsStr;
		return str;
	}
	
}