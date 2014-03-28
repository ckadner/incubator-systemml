/**
 * IBM Confidential
 * OCO Source Materials
 * (C) Copyright IBM Corp. 2010, 2014
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what has been deposited with the U.S. Copyright Office.
 */


package com.ibm.bi.dml.runtime.matrix.operators;

import com.ibm.bi.dml.runtime.DMLRuntimeException;
import com.ibm.bi.dml.runtime.functionobjects.Power;
import com.ibm.bi.dml.runtime.functionobjects.ValueFunction;


public class LeftScalarOperator extends ScalarOperator 
{
	@SuppressWarnings("unused")
	private static final String _COPYRIGHT = "Licensed Materials - Property of IBM\n(C) Copyright IBM Corp. 2010, 2014\n" +
                                             "US Government Users Restricted Rights - Use, duplication  disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	
	public LeftScalarOperator(ValueFunction p, double cst) {
		super(p, cst);
		
		//disable sparse-safe for c^M because 1^0=1
		if( fn instanceof Power )
			sparseSafe = false;
	}

	@Override
	public double executeScalar(double in) throws DMLRuntimeException {
		return fn.execute(_constant, in);
	}
	
	@Override
	public void setConstant(double cst) 
	{
		super.setConstant(cst);
		
		//disable sparse-safe for c^M because 1^0=1
		if( fn instanceof Power )
			sparseSafe = false;
	}
}
