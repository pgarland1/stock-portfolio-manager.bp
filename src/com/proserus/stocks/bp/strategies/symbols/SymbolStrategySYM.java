package com.proserus.stocks.bp.strategies.symbols;

import java.util.Collection;

import com.proserus.stocks.bp.FilterBp;
import com.proserus.stocks.model.analysis.Analysis;
import com.proserus.stocks.model.transactions.Transaction;

public interface SymbolStrategySYM {
	void process(Analysis analysis, Collection<Transaction> transactions, FilterBp filter);
}