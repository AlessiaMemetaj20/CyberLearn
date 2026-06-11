package com.alessia.cyberlearn.data

import com.alessia.cyberlearn.R
import com.alessia.cyberlearn.models.Question
import com.alessia.cyberlearn.models.Topic

object TopicRepository {

    val topics: List<Topic> = listOf(
        Topic(
            id = 1,
            title = "Phishing",
            subtitle = "Spot fake emails and messages",
            iconResId = R.drawable.ic_phishing,
            lessonText = "Phishing is a type of social engineering attack where attackers send fraudulent messages — usually emails — that look like they come from a trusted source. The goal is to trick you into clicking a malicious link, downloading malware, or revealing sensitive information like passwords or credit card numbers.\n\nWarning signs:\n• Urgent or threatening language\n• Generic greetings like \"Dear Customer\"\n• Suspicious sender address (check the domain carefully)\n• Links that don't match the displayed text\n• Unexpected attachments\n\nAlways verify by contacting the company directly through their official website — never through links in the suspicious message.",
            questions = listOf(
                Question("Which is the BIGGEST red flag in an email?",
                    listOf("It uses your first name", "It contains the company logo",
                        "It asks you to click a link urgently to avoid account suspension",
                        "It is signed by the support team"), 2),
                Question("What should you do before clicking a link in an email?",
                    listOf("Click it quickly to see where it goes",
                        "Hover over it to preview the real URL",
                        "Forward it to all your contacts",
                        "Reply asking the sender if it is safe"), 1),
                Question("A phishing attack is a form of:",
                    listOf("Physical theft", "Hardware failure",
                        "Social engineering", "Operating system bug"), 2),
                Question("Which sender address looks MOST suspicious?",
                    listOf("support@paypal.com", "noreply@paypal.com",
                        "service@paypaI-security.com", "billing@paypal.com"), 2),
                Question("If you receive a suspicious email from \"your bank\", you should:",
                    listOf("Reply with your account details to verify",
                        "Click the link to log in and check",
                        "Contact your bank directly using their official phone number",
                        "Delete your bank account"), 2)
            )
        ),
        Topic(
            id = 2,
            title = "Passwords",
            subtitle = "Build strong, unique passwords",
            iconResId = R.drawable.ic_password,
            lessonText = "A strong password is your first line of defense against unauthorized access. Weak or reused passwords are responsible for the majority of account compromises worldwide.\n\nRules of a strong password:\n• At least 12 characters long\n• Mix uppercase, lowercase, numbers, and symbols\n• Avoid dictionary words, names, and birthdays\n• Never reuse the same password across multiple accounts\n• Use a password manager (Bitwarden, 1Password, KeePass)\n\nEnable two-factor authentication (2FA) wherever possible. Even if your password is stolen, an attacker still needs the second factor to log in.",
            questions = listOf(
                Question("Recommended minimum length of a strong password?",
                    listOf("6 characters", "8 characters", "12 characters", "20 characters"), 2),
                Question("Which password is strongest?",
                    listOf("password123", "Sindi2003", "G7\$kL!9p#Wq2", "qwerty"), 2),
                Question("What does 2FA stand for?",
                    listOf("Two-Factor Authentication", "Two-File Access",
                        "Fast Forward Authentication", "Firewall and Antivirus"), 0),
                Question("Safest place to store many passwords?",
                    listOf("A sticky note on your monitor", "A text file on your desktop",
                        "A reputable password manager", "Browser autofill, unencrypted"), 2),
                Question("Why is reusing the same password across sites dangerous?",
                    listOf("It uses more memory",
                        "If one site is breached, all your accounts are at risk",
                        "It slows down your computer", "It is not dangerous"), 1)
            )
        ),
        Topic(
            id = 3,
            title = "Social Engineering",
            subtitle = "Recognize manipulation tactics",
            iconResId = R.drawable.ic_social,
            lessonText = "Social engineering is the art of manipulating people into breaking normal security procedures. Instead of attacking a computer, the attacker attacks the human — usually the weakest link in any security system.\n\nCommon tactics:\n• Pretexting — inventing a scenario (\"I'm from IT and need your password\")\n• Baiting — leaving a malware-infected USB stick for someone to plug in\n• Tailgating — physically following an employee through a secure door\n• Quid pro quo — offering a benefit in exchange for information\n\nDefense: verify identity through a separate, trusted channel before acting on unusual requests. A real IT department will never ask for your password.",
            questions = listOf(
                Question("Social engineering primarily attacks:",
                    listOf("Servers", "Networks", "People", "Databases"), 2),
                Question("Someone calls claiming to be from IT and asks for your password. You should:",
                    listOf("Give it to them quickly",
                        "Refuse and verify through your IT department directly",
                        "Give them a slightly wrong password",
                        "Whisper it so no one else hears"), 1),
                Question("Leaving a USB drive in a parking lot is called:",
                    listOf("Phishing", "Baiting", "Spoofing", "Sniffing"), 1),
                Question("Tailgating in security means:",
                    listOf("Driving too close to another car",
                        "Following an authorized person through a secure door",
                        "Spying on someone's screen", "Sending repeated emails"), 1),
                Question("Best general defense against social engineering?",
                    listOf("Stronger firewalls", "Faster antivirus",
                        "Verifying identity through a separate trusted channel",
                        "Longer passwords"), 2)
            )
        ),
        Topic(
            id = 4,
            title = "Network Security",
            subtitle = "Stay safe on Wi-Fi and online",
            iconResId = R.drawable.ic_network,
            lessonText = "Network security protects the integrity, confidentiality, and availability of data while it travels between devices. Most users connect to multiple networks every day — home Wi-Fi, work, cafes, airports — and each one carries its own risks.\n\nKey practices:\n• Avoid sensitive activity on public Wi-Fi\n• Use a VPN to encrypt your traffic on untrusted networks\n• Check for HTTPS (the padlock) before entering passwords\n• Keep your router firmware updated\n• Disable WPS and use WPA3 or WPA2 encryption at home\n\nAttackers on the same Wi-Fi can perform man-in-the-middle attacks. HTTPS and VPNs are your main defense.",
            questions = listOf(
                Question("What does HTTPS provide that HTTP does not?",
                    listOf("Faster speed", "Encryption of data in transit",
                        "Free Wi-Fi", "Larger storage"), 1),
                Question("Which is the SAFEST action on public Wi-Fi?",
                    listOf("Logging into your bank",
                        "Using a VPN to encrypt your traffic",
                        "Sending passwords in plain text",
                        "Disabling your firewall"), 1),
                Question("A man-in-the-middle attack happens when an attacker:",
                    listOf("Stands between two people physically",
                        "Intercepts communication between two parties without their knowledge",
                        "Hacks the CPU", "Sends a phishing email"), 1),
                Question("Which Wi-Fi encryption is currently strongest?",
                    listOf("WEP", "WPA", "WPA2", "WPA3"), 3),
                Question("Why change your router's default admin password?",
                    listOf("It is required by law",
                        "Default passwords are public knowledge and easily exploited",
                        "It makes Wi-Fi faster", "Routers stop working otherwise"), 1)
            )
        )
    )

    fun getById(id: Int): Topic? = topics.find { it.id == id }
}