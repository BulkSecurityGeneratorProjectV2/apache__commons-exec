/* 
 * Copyright 2005  The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.commons.exec;

import java.io.File;
import java.util.Arrays;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public final class TestUtil {

    private TestUtil() {
    }

    public static File resolveScriptForOS(String script) {
        if (OS.isFamilyWindows()) {
            return new File(script + ".bat");
        } else if (OS.isFamilyUnix()) {
            return new File(script + ".sh");
        } else {
            throw new AssertionFailedError("Test not supported for this OS");
        }
    }
    
    
    public static void assertEquals(Object[] expected, Object[] actual, boolean orderSignificant) {
    	
    	if(expected == null && actual == null) {
    		// all good
    	} else if (actual == null) {
    		throw new AssertionFailedError("Expected non null array");
    	} else if (expected == null) {
    		throw new AssertionFailedError("Expected null array");
    	} else {
    		if(expected.length != actual.length) {
    			throw new AssertionFailedError("Arrays not of same length");
    		}
    		
    		if(!orderSignificant) {
    			Arrays.sort(expected);
    			Arrays.sort(actual);
    		}
    		
    		for (int i = 0; i < actual.length; i++) {
				TestCase.assertEquals("Array element at " + i, expected[i], actual[i]);
			}
    	}
    }
}