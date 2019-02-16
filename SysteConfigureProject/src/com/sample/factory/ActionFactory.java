package com.sample.factory;

import com.sample.action.impl.Action;
import com.sample.action.impl.HttpApiCallAction;

public class ActionFactory {
	private Action action;

	public ActionFactory() {

	}

	public Action getAction(int actionId) {
		switch (actionId) {
		case 1:
			action = new HttpApiCallAction();
			break;
		}
		return action;
	}
}
