/*
 * Fortify Plugin for SonarQube
 * Copyright (C) 2014 Vivien HENRIET and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.fortify.base;

import org.sonar.api.rule.Severity;

public final class FortifyUtils {
  private FortifyUtils() {
    // only static stuff
  }

  public static String fortifyToSonarQubeSeverity(String fortifySeverity) {
    String severity;
    Double level = Double.valueOf(fortifySeverity);
    if (level >= 4.0) {
      severity = Severity.BLOCKER;
    } else if (level >= 3.0) {
      severity = Severity.CRITICAL;
    } else if (level >= 2.0) {
      severity = Severity.MAJOR;
    } else if (level >= 1.0) {
      severity = Severity.MINOR;
    } else {
      severity = Severity.INFO;
    }
    return severity;

  }
}
