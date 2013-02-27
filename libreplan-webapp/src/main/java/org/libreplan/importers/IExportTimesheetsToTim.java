/*
 * This file is part of LibrePlan
 *
 * Copyright (C) 2013 St. Antoniusziekenhuis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.libreplan.importers;

import org.libreplan.business.common.entities.Connector;
import org.libreplan.business.orders.entities.Order;
import org.libreplan.business.orders.entities.OrderSyncInfo;

/**
 * Export time sheets of an existing order to Tim SOAP server using
 * {@link TimSoapClient}.
 *
 * It exports the time sheets between periods current-date minus
 * <code>NrDaysTimesheetToTim</code> specified in the Tim {@link Connector} and
 * the current-date
 *
 * @author Miciele Ghiorghis <m.ghiorghis@antoniusziekenhuis.nl>
 */
public interface IExportTimesheetsToTim {

    /**
     * Exports time sheets of the specified <code>productCode</code> and
     * <code>{@link Order}</code> to Tim SOAP server
     *
     * @param productCode
     *            the Tim's productCode
     * @param order
     *            an existing order
     */
    boolean exportTimesheets(String productCode, Order order);

    /**
     * Loops through all existing {@link Order}s and searches for last
     * synchronized order. if found, start exporting the time sheets of that
     * order to Tim SOAP server. if not found write info to the log file.
     */
    void exportTimesheets();

    /**
     * Gets the most recent synchronized time sheet info
     *
     * @param order
     *            the order
     * @return recent synchronized time sheet info
     */
    OrderSyncInfo getOrderLastSyncInfo(Order order);

}
