package com.sampl.test;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.sample.action.impl.Action;
import com.sample.factory.ActionFactory;
import com.sample.query.impl.QueryExecute;
import com.sample.query.impl.QueryLoader;

public class Execute {

	public static void main(String[] args) {

	}

	public void execute() {
		QueryLoader queryLoader = new QueryLoader();
		QueryExecute queryExecute = new QueryExecute();
		ActionFactory actionFactory = new ActionFactory();
		List<Pair<Integer, String>> listOfPairOfActionIdQuery = queryLoader.mapOfActionIdToQueryString();
		Iterator<Pair<Integer, String>> itrPair = listOfPairOfActionIdQuery.iterator();
		while (itrPair.hasNext()) {
			Pair<Integer, String> pairOfIntgrString = itrPair.next();
			List<Object> queryResult = queryExecute.executeQiery(pairOfIntgrString.getRight());
			Action action = actionFactory.getAction(pairOfIntgrString.getLeft());
			action.executeAction(queryResult);
		}
	}
}
