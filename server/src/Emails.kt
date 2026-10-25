package org.example.demo.server

import org.example.demo.Email

val emails =
    listOf(
        Email(
            id = 1,
            from = "Pingu Chinstrap",
            subject = "Egg #2 hatched!",
            date = "2026-11-02",
            body =
                """
                Dear colony,

                At 04:17 this morning our second egg hatched. The chick is grey, fluffy and already very loud.
                We have named her Nyrøysa, after the beach she was born on.

                Visitors are welcome, but please bring krill and keep your flippers to yourself.

                Proud regards,
                Pingu
                """.trimIndent(),
        ),
        Email(
            id = 2,
            from = "Colony Council",
            subject = "Fur seals took our beach again",
            date = "2026-11-01",
            body =
                """
                Hello everyone,

                The Antarctic fur seals have once again claimed the best part of Nyrøysa.
                They are big, they are loud, and they do not respond to formal complaints.

                Until further notice, please nest on the upper slope and avoid eye contact.

                The Colony Council
                """.trimIndent(),
        ),
        Email(
            id = 3,
            from = "Krill Forecast Service",
            subject = "Weekly krill forecast: excellent",
            date = "2026-10-30",
            body =
                """
                This week's forecast for the waters around Bouvetøya:

                Monday: dense krill swarms to the west.
                Tuesday: krill, krill and more krill.
                Wednesday: some squid. Approach with caution.
                Thursday to Sunday: krill.

                Happy fishing!
                """.trimIndent(),
        ),
        Email(
            id = 4,
            from = "Glacier Watch",
            subject = "Calving alert on Christensen Glacier",
            date = "2026-10-28",
            body =
                """
                ATTENTION

                A large chunk of ice is expected to break off the Christensen Glacier this afternoon.
                93% of Bouvetøya is covered in ice, so this happens a lot, but please stay off the ice edge anyway.

                Glacier Watch
                """.trimIndent(),
        ),
        Email(
            id = 5,
            from = "Mac the Macaroni",
            subject = "About my hair",
            date = "2026-10-27",
            body =
                """
                Hi all,

                I have noticed some of you staring at my yellow crest. Yes, it is natural.
                No, I will not tell you which product I use.

                Stylishly yours,
                Mac
                """.trimIndent(),
        ),
        Email(
            id = 6,
            from = "Research Station",
            subject = "Visit from the Norwegian Polar Institute",
            date = "2026-10-25",
            body =
                """
                Dear penguins,

                Researchers from the Norwegian Polar Institute will visit the island next week to count you.
                Please stand still, do not swap places, and try not to waddle off mid-count.

                Last year the total came out as 'a lot'. This year we are aiming for an actual number.

                Thank you for your cooperation.
                """.trimIndent(),
        ),
        Email(
            id = 7,
            from = "Skua Neighbourhood Watch",
            subject = "Suspicious skua spotted near the nests",
            date = "2026-10-22",
            body =
                """
                A brown skua has been seen circling the nests on the north side.

                Please keep an eye on your eggs and chicks. If you see the skua, flap your flippers
                and make as much noise as possible. This is also how we deal with most problems here.

                Stay vigilant!
                """.trimIndent(),
        ),
        Email(
            id = 8,
            from = "Colony Council",
            subject = "Huddle schedule for the winter storm",
            date = "2026-10-20",
            body =
                """
                A storm is on its way. Please follow the huddle schedule:

                - Outer ring: rotate inwards every 20 minutes.
                - Inner ring: rotate outwards every 20 minutes. No exceptions, Pingu.
                - Chicks: stay in the middle and stay warm.

                We are all in this together. Literally.
                """.trimIndent(),
        ),
    )
