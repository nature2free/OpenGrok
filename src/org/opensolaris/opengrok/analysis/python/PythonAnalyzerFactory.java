/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License (the "License").
 * You may not use this file except in compliance with the License.
 *
 * See LICENSE.txt included in this distribution for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at LICENSE.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */

/*
 * Copyright 2010 Sun Microsystems, Inc.  All rights reserved.
 * Use is subject to license terms.
 */

package org.opensolaris.opengrok.analysis.python;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.opensolaris.opengrok.analysis.FileAnalyzer;
import org.opensolaris.opengrok.analysis.FileAnalyzer.Genre;
import org.opensolaris.opengrok.analysis.FileAnalyzerFactory;
import org.opensolaris.opengrok.configuration.Project;
import org.opensolaris.opengrok.history.Annotation;

/**
 *
 * @author Lubos Kosco
 */

public class PythonAnalyzerFactory extends FileAnalyzerFactory {
    private static final String[] SUFFIXES = {
        "PY"
    };

    private static final String[] MAGICS = {
        "#!/usr/bin/env python"
    };

    public PythonAnalyzerFactory() {
        super(null, SUFFIXES, MAGICS, null, "text/plain", Genre.PLAIN);
    }

    @Override
    protected FileAnalyzer newAnalyzer() {
        return new PythonAnalyzer(this);
    }

    @Override
    public void writeXref(Reader in, Writer out, Annotation annotation, Project project)
        throws IOException {
        PythonAnalyzer.writeXref(in, out, annotation, project);
    }
}