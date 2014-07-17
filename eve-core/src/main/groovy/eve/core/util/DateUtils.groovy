package eve.core.util

class DateUtils {

    final static String DATE_FORMAT = 'yyyy-MM-dd HH:mm:ss'

    static String formatDate(Date date) {
        date ? date.format(DATE_FORMAT) : null
    }

}