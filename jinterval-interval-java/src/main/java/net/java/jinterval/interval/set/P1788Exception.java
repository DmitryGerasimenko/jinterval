/*
 * Copyright (c) 2012, JInterval Project.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.java.jinterval.interval.set;

/**
 *
 * Exception defined in P1788 standard
 */
public class P1788Exception extends RuntimeException {

    /**
     * Creates a new instance of <code>P1788Exception</code> without detail
     * message.
     */
    public P1788Exception() {
    }

    /**
     * Constructs an instance of <code>P1788Exception</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public P1788Exception(String msg) {
        super(msg);
    }

    /**
     * Creates a new instance of <code>P1788Exception</code> without detail
     * message.
     *
     * @param cause
     */
    public P1788Exception(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an instance of <code>P1788Exception</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     * @param cause
     */
    public P1788Exception(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     *
     * @return interval which encloses inputs of interval constructor.
     */
    public SetInterval getValue() {
        return EmptyInterval.NaI();
    }
}
